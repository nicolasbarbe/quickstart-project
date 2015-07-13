/**
 * This file Copyright (c) 2012-2014 Magnolia International
 * Ltd.  (http://www.magnolia-cms.com). All rights reserved.
 *
 *
 * This file is dual-licensed under both the Magnolia
 * Network Agreement and the GNU General Public License.
 * You may elect to use one or the other of these licenses.
 *
 * This file is distributed in the hope that it will be
 * useful, but AS-IS and WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE, TITLE, or NONINFRINGEMENT.
 * Redistribution, except as permitted by whichever of the GPL
 * or MNA you select, is prohibited.
 *
 * 1. For the GPL license (GPL), you can redistribute and/or
 * modify this file under the terms of the GNU General
 * Public License, Version 3, as published by the Free Software
 * Foundation.  You should have received a copy of the GNU
 * General Public License, Version 3 along with this program;
 * if not, write to the Free Software Foundation, Inc., 51
 * Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * 2. For the Magnolia Network Agreement (MNA), this file
 * and the accompanying materials are made available under the
 * terms of the MNA which accompanies this distribution, and
 * is available at http://www.magnolia-cms.com/mna.html
 *
 * Any modifications to this file must keep this entire header
 * intact.
 *
 */
package info.magnolia.services.quickstart.templates;

import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.TemplateDefinition;
import info.magnolia.templating.functions.TemplatingFunctions;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import com.google.inject.Inject;


public class NavigationModel  <RD extends TemplateDefinition> extends RenderingModelImpl<TemplateDefinition> {

    protected  TemplatingFunctions templatingFunctions;

    @Inject
    public NavigationModel(Node content, TemplateDefinition definition, RenderingModel<?> parent, TemplatingFunctions templatingFunctions) {
        super(content, definition, parent);
        this.templatingFunctions = templatingFunctions;
    }

    public List<Node> getSections() throws Exception{
        Node siteRoot;
        try {
            siteRoot = templatingFunctions.root(content, "mgnl:page");
        } catch (RepositoryException e) {
            throw new Exception("Site root cannot be found");
        }

        return templatingFunctions.children(siteRoot, "mgnl:page");
    }

    public Node currentSection() throws Exception{
        List<Node> ancestors;
        try {
            ancestors = templatingFunctions.ancestors(this.content, "mgnl:page");
        } catch (RepositoryException e) {
            throw new Exception("Cannot find current section");
        }
        return ancestors.get(ancestors.size() - 2);
    }


}

[#assign sections = model.sections]
<nav class="navbar navbar-default">
    <div class="container-fluid"></div>

        <div class="navbar-header">
           <a class="navbar-brand" href="#">Project Name</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">

            <ul class="nav navbar-nav">
            [#list sections as section]
                <li role="presentation"><a href="${cmsfn.link(section)}">${section.name}</a></li>
            [/#list]
            </ul>

            <ul class="nav navbar-nav navbar-right">
            [#list components as component ]
                <li role="presentation">[@cms.component content=component /]</li>
            [/#list]
            </ul>

        </div>
    </div>
</nav>
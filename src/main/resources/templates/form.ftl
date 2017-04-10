
<!DOCTYPE HTML>
<html>
<head>
</head>
<body>
<h2><a href=/ />Home</a></h2>

<table border="1">
    <caption>Table</caption>
    <#list table as nameProject,repository>

        <tr>

            <td>${nameProject}</td>
            <td></td>
        <#list allUsers as users>
            <td>${users}</td>
        </#list>
        </tr>

    <tr>
        <#list repository as nameRepo, users>
        <td></td>

        <td>${nameRepo}</td>
            <#list allUsers  as userProject>
            <#--<#list users.values as user>-->




            <#if userProject? >
            <td>${user.permission}</td>

            <#--<#else >-->
            <#--<td></td>-->
        <#--</#if>-->

        </#list>
        </#list>

    </tr>
 </#list>
</#list>


</table>

</body>
</html>

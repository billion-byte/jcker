<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Hello World!</title>
</head>
<body>
<#list grouplist as group>
<span>${group.id}</span>
<span>${group.name}</span>
<span>${group.flag}</span>
<span>${group.code}</span></br>
</#list>
</body>
</html>
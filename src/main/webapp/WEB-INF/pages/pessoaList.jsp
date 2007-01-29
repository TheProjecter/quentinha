<%@ include file="/common/taglibs.jsp"%> 
 
<head> 
    <title><fmt:message key="pessoaList.title"/></title> 
    <content tag="heading"><fmt:message key="pessoaList.heading"/></content> 
</head> 
 
<c:set var="buttons"> 
    <input type="button" style="margin-right: 5px" 
        onclick="location.href='<c:url value="/editPerson.html"/>'" 
        value="<fmt:message key="button.add"/>"/> 
     
    <input type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'" 
        value="<fmt:message key="button.done"/>"/> 
</c:set> 
 
<c:out value="${buttons}" escapeXml="false" /> 
 
<s:set name="pessoas" value="pessoas" scope="request"/> 
<display:table name="pessoas" class="table" requestURI="" id="pessoaList" export="true" pagesize="25"> 
    <display:column property="id" sortable="true" href="editPessoa.html"  
        paramId="id" paramProperty="id" titleKey="pessoa.id"/> 
    <display:column property="nome" sortable="true" titleKey="pessoa.Nome"/> 
    <display:column property="sobreNome" sortable="true" titleKey="pessoa.SobreNome"/> 
 
    <display:setProperty name="paging.banner.item_name" value="pessoa"/> 
    <display:setProperty name="paging.banner.items_name" value="pessoas"/> 
 
    <display:setProperty name="export.excel.filename" value="Pessoa List.xls"/> 
    <display:setProperty name="export.csv.filename" value="Pessoa List.csv"/> 
    <display:setProperty name="export.pdf.filename" value="Pessoa List.pdf"/> 
</display:table> 
 
<c:out value="${buttons}" escapeXml="false" /> 
 
<script type="text/javascript"> 
    highlightTableRows("pessoaList"); 
</script> 
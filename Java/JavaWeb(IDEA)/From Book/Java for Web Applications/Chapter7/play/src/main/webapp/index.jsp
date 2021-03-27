<%@ include file="WEB-INF/jsp/base.jspf"%>

<c:import url="http://www.example.news/feed.xml" var="feed"/>
<x:parse doc="${feed}" var="parsedDoc"/>

<x:out select="$parsedDoc/feed/title"/>

<x:forEach select="$parsedDoc/feed/stories//story">
    <x:out select="@tilte"/> <br/>
    <x:out select="@url"/> <br/> <br/>
</x:forEach>
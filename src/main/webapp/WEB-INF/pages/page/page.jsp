<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="pagination">
			<c:if test="${page.curPage==1 }">
				<li class="active"><a href="#">&laquo;</a></li>
			</c:if>
			<c:if test="${page.curPage!=1 }">
				<li>
				<c:if test="${!empty search }">
					<a href="${action}?curPage=${page.curPage-1 }&search=${search}">&laquo;</a>
				</c:if>
				<c:if test="${empty search }">
					<a href="${action }?curPage=${page.curPage-1 }">&laquo;</a>
				</c:if>
				</li>
			</c:if>
				<c:forEach  var="p" begin="1" end="${page.totalPage }">
				
				<c:if test="${page.curPage==p }">
					<li class="active">
						<a href="#" class="">${p }</a>
					</li>
				</c:if>
				<c:if test="${page.curPage!=p }">
					<li>
						<c:if test="${!empty search }">
							<a href="${action }?curPage=${p }&search=${search}" class="">${p }</a>
						</c:if>
						<c:if test="${empty search }">
							<a href="${action }?curPage=${p }" class="">${p }</a>
						</c:if>
					</li>
				</c:if>
				</c:forEach>
				<c:if test="${page.curPage==page.totalPage }">
					<li class="active"><a href="#">&raquo;</a></li>
				</c:if>
				<c:if test="${page.curPage!=page.totalPage }">
					<li>
					<c:if test="${!empty search }">
						<a href="${action }?curPage=${page.curPage+1 }&search=${search}">&raquo;</a>
					</c:if>
					<c:if test="${empty search }">
						<a href="${action }?curPage=${page.curPage+1 }">&raquo;</a>
					</c:if>
					
					</li>
				</c:if>
			</ul>
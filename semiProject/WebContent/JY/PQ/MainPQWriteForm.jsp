<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>1:1 문의</title>

<script>
	var rowIndex = 1;

	function addFile(form) {
		if (rowIndex > 4)
			return false;

		rowIndex++;
		var getTable = document.getElementById("insertTable");
		var oCurrentRow = getTable.insertRow(getTable.rows.length);
		var oCurrentCell = oCurrentRow.insertCell(0);
		oCurrentCell.innerHTML = "<tr><td colspan=6><INPUT TYPE='FILE' NAME='filename" + rowIndex + "'></td></tr>";
	}
	function deleteFile(form) {
		if (rowIndex < 2) {
			return false;
		} else {
			rowIndex--;

		}
		var getTable = document.getElementById("insertTable");
		getTable.deleteRow(rowIndex);
	}
	function writesubmit(writeForm) {
		alert("1:1문의가 접수되었습니다.");
		writeForm.submit();
	}
</script>
<style>
.mainimg {
	width: 100%;
	height: 35%;
}

.detaildiv {
	wdith: 60%;
}

.imgdiv {
	width: 40%;
	height: 50%;
	display: inline-block;
	margin-right: 20;
}

.contentdiv {
	width: 50%;
	height: 50%;
	display: inline;
}

.tablediv {
	width: 85%;
	margin: 0 auto;
}

.tablediv table {
	width: 100%;
}
</style>
<script>

function test(){
	var value = $("#pq_type option:selected").val();
	alert(value);
	var value2 =$("#sendtype").val();
	$("#sendtype").val() = value;
	alert(value2)
}
</script>
</head>

<body>
	<!-- Header -->
	<tiles:insertDefinition name="mainheader" />

	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<a href="/semiProject/JY/NoticeForm.do"><p>고객센터</p></a> <a
					href="/semiProject/JY/PQForm.do"><h2>1:1 문의하기</h2></a>
			</header>
		</div>
	</section>
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
					<div class=tablediv>
						<form name="writeForm" action="/semiProject/JY/PQWritePro.do"
							method="post" enctype="multipart/form-data">
							
							<input type="hidden" name="writer" value="${sessionScope.id }">
							<input type="hidden" id="sendtype" name="sendtype" value="결제문의">
							<table border="1" cellspacing="0" cellpadding="0" align="center">
								<tr height="5%" style="background-color:white;">
									<td align="center">제목</td>
									<td colspan="3"><input name="pq_subject" type="text"
										size="60%"></td>
									<td align="center">문의분류</td>
									<td><select id="pq_type" onchange="test()">
											<option value="결제문의">결제문의</option>
											<option value="거래문의">거래문의</option>
											<option value="기타문의">기타문의</option>
									</select></td>
								</tr>
								<tr height="30%">
									<td align="center">상세내용</td>
									<td colspan="5"><textarea style="resize: none;"
											name="pq_content" rows="18" cols="80"></textarea></td>
								</tr>
								<tr height="5%" style="background-color:white;">
									<td align="center">사진첨부</td>
									<td colspan=5><table width="100%" id="insertTable">
											<tr>
												<td valign=bottom><INPUT type='file' maxLength='100'
													name='filename1' size='80%'></td>
												<td><input type="button" value="추가"
													onClick="addFile(this.form)" border=0 style='cursor: hand'>
													<input type="button" value="삭제"
													onClick='deleteFile(this.form)' border=0
													style='cursor: hand'></td>
											</tr>

										</table></td>

								</tr>
								<tr>
								</tr>
								<tr height="5%" style="background-color:white;">
									<td colspan=6 align="right"><input type="button"
										value="완료" onclick="writesubmit(this.form)"></td>
								</tr>

							</table>
						</form>
					</div>
				</div>
			</div>
		</div>



	</section>

	<!-- footer -->
	<tiles:insertDefinition name="mainfooter" />
	
	<!-- script -->
	<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.scrollex.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/skel.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/util.js"></script>
	<script src="<%=request.getContextPath() %>/js/main.js"></script>
</body>
</html>

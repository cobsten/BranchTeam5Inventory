
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.fakeLabel {
	background: rgba(0, 0, 0, 0);
	border: none;
}
</style>

<script type="text/javascript">
	function OnSubmitForm() {
		if (document.pressed == 'Add') {
			document.orderSelection.action = "/inventory/admin/order/add";
		} else if (document.pressed == 'Reset') {
			document.orderSelection.action = "/inventory/admin/order/reset";
		} else if (document.pressed == 'AutoGenerate') {
			document.orderSelection.action = "/admin/order/autogenerate";
		} else if (document.pressed == 'Submit') {
			document.orderSelection.action = "/admin/order/submit";
		}
	}
</script>
</head>



<!-- body -->
<body>

	<!-- form -->
	<form id="form1" name="orderSelection" method="post"
		onsubmit="return OnSubmitForm()">

		<h3>New Order Page</h3>

		<!-- table -->
		<table>

			<!-- table heading -->
			<thead>

				<tr>
					<th>PartNo</th>
					<th>Supplier / UnitPrice / MinOrderQty</th>
					<th>CurrentQty</th>
					<th>OrderQty</th>
				</tr>
			</thead>



			<!-- table body -->
			<tbody>

				<!-- orderCartItem -->
				<c:forEach var="orderItem" items="${ORDERLIST}" varStatus="theCount">
					<tr class="listRecord">

						<!-- partNo -->
						<td align="left"><input type="text" class="fakeLabel"
							id="partNo${theCount.index}" name="partNo${theCount.index}"
							value="${orderItem.product.partNo}" readonly="readonly"></td>

						<!-- productSupplier -->
						<td>
							<!-- listBox --> <select name="productSupplier${theCount.index}">
								<!-- productSupplierOptions -->
								<c:forEach var="p" items="${orderItem.prodSupList}"
									varStatus="mapIndex">
									<option value="${p.id.supplierId}">${p.id.supplierId}
										/ ${p.unitPrice} / ${p.minimumReorderQty}</option>
								</c:forEach>
						</select>
						</td>

						<!-- currentQty -->
						<td align="left"><input type="text" class="fakeLabel"
							id="currentQty${theCount.index}"
							name="currentQty${theCount.index}"
							value="${orderItem.product.availableQty}" readonly="readonly"></td>

						<!-- orderQty -->
						<td align="left"><input type="text"
							id="orderQty${theCount.index}" name="orderQty${theCount.index}"
							value="${orderItem.quantity}"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<%--
		<div>
			<!-- partNo input -->
			<input type="text" name="partNo">

			<!-- addButton -->
			<input type="button" name="add" value="Add" onclick="askForAdd()">
			<br>

			<!-- errorMessage -->
			<p style="color: red;">${errorMessage}</p>

			<!-- resetButton  -->
			<input type="button" class="button" name="reset" value="Reset">
			<br>

			<!-- autoGenerateButton -->
			<input type="button" class="button" name="autoGenerate"
				value="AutoGenerate"> <br>

			<!-- submitButton -->
			<input type="button" class="button" name="submit" value="Submit">
			<br>
		</div>
--%>

		<div>
			<!-- partNo input -->
			<input type="text" name="partNo">

			<!-- addButton -->
			<input type="submit" class="button"
				onclick="document.pressed=this.value" value="Add"> <br>

			<!-- errorMessage -->
			<p style="color: red;">${errorMessage}</p>

			<!-- resetButton  -->
			<input type="submit" class="button"
				onclick="document.pressed=this.value" value="Reset"> <br>

			<!-- autoGenerateButton -->
			<input type="submit" class="button"
				onclick="document.pressed=this.value" value="AutoGenerate">
			<br>

			<!-- submitButton -->
			<input type="submit" class="button"
				onclick="document.pressed=this.value" value="Submit"> <br>
		</div>


	</form>
</body>
</html>
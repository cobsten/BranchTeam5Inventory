
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">




<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



<script type="text/javascript">
	function OnSubmitForm() {
		if (document.pressed == 'Add') {
			document.orderSelection.action = "/admin/order/new";
		} else if (document.pressed == 'Reset') {
			document.orderSelection.action = "/admin/order/reset";
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
	<form name="orderSelection" method="post"
		onsubmit="return OnSubmitForm();">

		<h3>New Order Page</h3>

		<!-- table -->
		<table>

			<!-- table heading -->
			<thead>

				<tr>
					<th align="center">PartNo</th>
					<th>Supplier / UnitPrice / MinOrderQty</th>
					<th>CurrentQty</th>
					<th>OrderQty</th>
				</tr>
			</thead>



			<!-- table body -->
			<tbody>

				<!-- orderCartItem -->
				<c:forEach var="orderItem" items="${ORDERLIST}" varStatus="mapIndex">
					<tr class="listRecord">

						<!-- partNo -->


						<td align="left"><input type="text" class="fakeLabel"
							id="partNo${mapIndex.index}" name="partNo${mapIndex.index}"
							value="${orderItem.product.partNo}"></td>







						<!-- productSupplier -->
						<td align="left">
							<!-- listBox --> <select name="productSupplier${mapIndex.index}">

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
							id="currentQty${mapIndex.index}"
							name="currentQty${mapIndex.index}"
							value=${ orderItem.product.availableQty}></td>


						<%--
						
						
						
						<!-- orderQty -->
						<td align="left"><input type="text"
							id="orderQty${mapIndex.index}" name="orderQty${mapIndex.index}"
							value="orderItem.orderDetail.transactionQty"></td>
							
							
							
							--%>


					</tr>
				</c:forEach>
			</tbody>


		</table>


		<div>
			<!-- addPartNo -->
			<input type="text" name="partNo"> <br>

			<!-- addButton -->
			<input type="submit" class="button"
				onclick="document.pressed=this.value" value="Add"> <br>

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
<%--
--%>
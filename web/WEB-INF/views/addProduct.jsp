<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add a product</title>
</head>
<body>
<form action="/products/addProduct" method="post">
	<table>
		<tr>
			<td>Product Name:</td>
			<td><input type="text" name="productName" /> </td>
		</tr>
		<tr>
			<td>Product Description:</td>
			<td><input type="text" name="description" /> </td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><input type="text" name="price" /> </td>
		</tr>
		<tr>
			<td>Product Type:</td>
			<td><input type="text" name="productType" /> </td>
		</tr>
	</table>
	<input type="submit"/>

</form>
</body>
</html>
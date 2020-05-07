<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project2Task2</title>
</head>
<body>
	<h1>Calculator</h1>
	<table>
		<div id="result">
			<form name="calculator" action="result" method="POST"
				target="resultFrame">
				<tr>
					Enter 2 numbers
					<br />
				</tr>
				<tr>
					x:
					<input type="number" name="first" id="first" required
						onkeypress="if ( isNaN( String.fromCharCode(event.keyCode) )) return false;" />
					<br />
				</tr>
				<tr>
					y:
					<input type="number" name="second" id="second" required
						onkeypress="if ( isNaN( String.fromCharCode(event.keyCode) )) return false;" />
					<br />
				</tr>
				<tr>
					Select operation:
					<select name="operation">
						<option value="1">Addition (x+y)</option>
						<option value="2">Multiplication (x*y)</option>
						<option value="3">Operation to determine if x and y are
							relatively prime</option>
						<option value="4">Modulo (x mod y)</option>
						<option value="5">Modular inverse (x-1 mod y)</option>
						<option value="6">Raise x to the power of y</option>
					</select>
				</tr>
				<tr>

					<button type="submit" class="button" value=index>Submit</button>
					</br>

				</tr>
			</form>
			<tr>
				<pre>${requestScope.output}</pre>


			</tr>
		</div>
	</table>
</body>

</html>
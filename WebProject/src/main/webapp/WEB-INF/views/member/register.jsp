<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<!-- 회원가입 -->
	<form action="/join" id="registerform" method="post">
		<p align="center">
		<table border="1" width="50%" height="80%" align='center'>
			<tr>
				<td colspan="3" align="center"><h2>회원 가입</h2></td>
			</tr>
			

			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;아이디</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input name="custId"	size="30" maxlength=50" required="required" />
				</td>
			</tr>
			
			<tr>
				<td width="17%" bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;닉네임</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input name="nickName" size="20" />
				</td>
			</tr>
			
			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;이메일</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="email" name="email"
					id="email" size="30" maxlength=50
					required="required" />
					<div id="emailDiv"></div>
				</td>
			</tr>
			
						<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;비밀번호</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="password" name="password" id="pw"
					size="20" required="required" />
					<div id=passwordDiv"></div>
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;비밀번호 확인</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="password" id="password"
					size="20" required="required" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;상세주소</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input id="addressDetail" name="addressDetail"
					size="20" required="required" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;주소</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input id="address" name="address"
					size="20" required="required" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;우편번호</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input id="zipcode" name="zipcode"
					size="20" required="required" />
				</td>
			</tr>
			
			<tr>
         		<td col style="background:papayawhip"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;성별</font></td>
         		<td>&nbsp;&nbsp;&nbsp;
         		<input type="radio" name="gender" 
         		size="20" required="required" value="m" checked="checked"/>
         		남자
         		<input type="radio" name="gender" value="w"/>
         		여자
         		</td>
      	 	</tr>
			
			<tr>
				<td align="center" colspan="3">
					<p></p> <input type="submit" value="회원가입"/>
					<input type="button" value="메인으로" class="btn btn-success">
					<p></p>
				</td>
			</tr>
			
		</table>
	</form>
	<br />
	<br />



}

	

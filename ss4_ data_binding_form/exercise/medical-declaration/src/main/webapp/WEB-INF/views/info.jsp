<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thông tin tờ khai y tế</title>
</head>
<body>
<h2>Thông tin tờ khai y tế</h2>
<p>Họ tên : <c:out value="${medicalDeclaration.hoTen}"/></p>
<p>Năm sinh : <c:out value="${medicalDeclaration.namSinh}"/></p>
<p>Giới tính : <c:out value="${medicalDeclaration.gioiTinh}"/></p>
<p>Quốc tịch : <c:out value="${medicalDeclaration.quocTich}"/></p>
<p>Số Cmnd : <c:out value="${medicalDeclaration.soCMND}"/></p>
<p>Thông tin đi lại : <c:out value="${medicalDeclaration.thongTinDiLai}"/></p>
<p>Biển số xe : <c:out value="${medicalDeclaration.bienSoXe}"/></p>
<p>Số ghế : <c:out value="${medicalDeclaration.soGhe}"/></p>
<p>Ngày khởi hành : <c:out value="${medicalDeclaration.ngayKhoiHanh}"/></p>
<p>Ngày kết thúc : <c:out value="${medicalDeclaration.ngayKetThuc}"/></p>
<p>Mô tả thêm : <c:out value="${medicalDeclaration.moTa}"/></p>
<p>Địa chỉ liên lạc : <c:out value="${medicalDeclaration.diaChiLienLac}"/></p>
<p>Địa chỉ nơi ở : <c:out value="${medicalDeclaration.diaChiNoiO}"/></p>
<p>Số điện thoại : <c:out value="${medicalDeclaration.soDienThoai}"/></p>
<p>Email : <c:out value="${medicalDeclaration.email}"/></p>
<p>Triệu Chứng : <c:out value="${medicalDeclaration.trieuChung}"/></p>
<p>Lịch sử phơi nhiễm : <c:out value="${medicalDeclaration.lichSuPhoiNhiem}"/></p>

<%--<p><c:out value="${medicalDeclarationt.hoTen}"/></p>--%>

















</body>
</html>

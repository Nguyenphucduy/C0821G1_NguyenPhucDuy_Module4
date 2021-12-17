<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thông tin tờ khai y tế</title>
</head>
<body>
<h2>Thông tin tờ khai y tế</h2>
<p>Họ tên : <c:out value="${hoTen}"/></p>
<p>Năm sinh : <c:out value="${namSinh}"/></p>
<p>Giới tính : <c:out value="${gioiTinh}"/></p>
<p>Quốc tịch : <c:out value="${quocTich}"/></p>
<p>Số Cmnd : <c:out value="${soCMND}"/></p>
<p>Thông tin đi lại : <c:out value="${thongTinDiLai}"/></p>
<p>Biển số xe : <c:out value="${bienSoXe}"/></p>
<p>Số ghế : <c:out value="${soGhe}"/></p>
<p>Ngày khởi hành : <c:out value="${ngayKhoiHanh}"/></p>
<p>Ngày kết thúc : <c:out value="${ngayKetThuc}"/></p>
<p>Mô tả thêm : <c:out value="${moTa}"/></p>
<p>Địa chỉ liên lạc : <c:out value="${diaChiLienLac}"/></p>
<p>Địa chỉ nơi ở : <c:out value="${diaChiNoiO}"/></p>
<p>Số điện thoại : <c:out value="${soDienThoai}"/></p>
<p>Email : <c:out value="${email}"/></p>
<p>Triệu Chứng : <c:out value="${trieuChung}"/></p>
<p>Lịch sử phơi nhiễm : <c:out value="${lichSuPhoiNhiem}"/></p>

<%--<p><c:out value="${medicalDeclarationt.hoTen}"/></p>--%>

















</body>
</html>

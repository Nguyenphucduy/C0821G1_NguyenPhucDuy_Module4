<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tờ Khai Y Tế</title>
</head>
<body>
<center>
    <h1>TỜ KHAI Y TẾ</h1>
    <h3>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ
        PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h3>
    <h5 style="color: red">Khuyến cáo:Khai báo thông tin sai lệch là vi phạm pháp luật Việt Nam và có thể
        xử ký hình sự</h5>
</center>
<center>
<form:form action="updateMedicalDeclaration" method="post" modelAttribute="medicalDeclaration">
    <table border="1">
        <tr>
            <td>
               Họ Tên :
            </td>
            <td>
                <form:input type="text" path="hoTen"/>
            </td>
        </tr>
        <tr>
            <td>
                Năm sinh :
            </td>
            <td>
                <form:input type="number" path="namSinh"/>
            </td>
        </tr>
        <tr>
            <td>
                giới tính:
            </td>
            <td>
                <form:select path="gioiTinh">
                    <form:options items="${gioiTinh}"/>;
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                Quốc tịch :
            </td>
            <td>
                <form:input type="text" path="quocTich"/>
            </td>
        </tr>
        <tr>
            <td>
                Số CMND:
            </td>
            <td>
                <form:input type="number" path="soCMND"/>
            </td>
        </tr>
        <tr>
            <td>
                Thông tin đi lại :
            </td>
            <td>
                <form:select path="thongTinDiLai">
                    <form:options items="${thongTinDiLai}"/>;
                </form:select>
            </td>
        </tr>

        <tr>
            <td>
                Số hiệu phương tiện :
            </td>
            <td>
                <form:input type="number" path="bienSoXe"/>
            </td>
        </tr>
        <tr>
            <td>
                Số ghế :
            </td>
            <td>
                <form:input type="number" path="soGhe"/>
            </td>
        </tr>
        <tr>
            <td>
                Ngày khởi hành :
            </td>
            <td>
                <form:input type="date" path="ngayKhoiHanh"/>
            </td>
        </tr>
        <tr>
            <td>
                Ngày kết thúc :
            </td>
            <td>
                <form:input type="date" path="ngayKetThuc" />
            </td>
        </tr>

        <tr>

            <td>
               Trong vòng 14 ngày qua Anh/Chị đến những tỉnh thành phố nào? :
            </td>
            <td>
                <form:textarea path="moTa"/>
            </td>
        </tr>
        <tr>
            <td>
               Địa chỉ liên lạc
            </td>
            <td>
                <form:input type="text" path="diaChiLienLac"/>
            </td>
        </tr>
        <tr>
            <td>
                Địa chỉ nơi ở:
            </td>
            <td>
                <form:input type="text" path="diaChiNoiO"/>
            </td>
        </tr>
        <tr>
            <td>
                Điện thoại
            </td>
            <td>
                <form:input type="text" path="soDienThoai"/>
            </td>
        </tr>
        <tr>
            <td>
                Email :
            </td>
            <td>
                <form:input type="text" path="email"/>
            </td>
        </tr>
        <tr>
            <td>
                Trong vòng 14 ngày vừa qua, Anh/Chị có xuất hiện triệu chứng nào sau đây không?
            </td>
            <td>
                <form:checkboxes path="trieuChung" items="${trieuChung}"/>
            </td>
        </tr>
        <tr>
            <td>
                Lịch sử phơi nhiễm: Trong vòng 14 ngày vừa qua, Anh/Chị có(*)
            </td>
            <td>
                <form:checkboxes path="lichSuPhoiNhiem" items="${lichSuPhoiNhiem}"/>
            </td>
        </tr>
    </table>
    <center>
    <p style="color: red"> Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch, thuộc quản lý của ban
        chỉ đạo quốc gia về Phòng chống dịch covid 19.Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý.</p>
    <p ><form:button>GỬI TỜ KHAI</form:button></p>
    </center>
</form:form>
</center>
</body>
</html>

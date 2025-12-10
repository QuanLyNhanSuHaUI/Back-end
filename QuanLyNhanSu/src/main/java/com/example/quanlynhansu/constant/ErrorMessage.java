package com.example.quanlynhansu.constant;

public class ErrorMessage {
    private ErrorMessage() {}
    public static final String ERR_EXCEPTION_GENERAL = "Có lỗi bất thường đã xảy ra";
    public static final String UNAUTHORIZED = "Xin lỗi, bạn cần cung cấp thông tin xác thực để thực hiện hành động này";
    public static final String ERR_DUPLICATE = "%s với giá trị %s đã tồn tại.";
    public static final String FORBIDDEN = "Xin lỗi, bạn không có quyền để thực hiện hành động này";
    public static final String INVALID_IMAGE_FILE="Chỉ cho phép hình ảnh PNG, JPG, JPEG, WEBP hoặc GIF";
    public static final String INVALID_JSON_FORMAT = "Dữ liệu gửi lên có định dạng JSON không hợp lệ. Vui lòng kiểm tra lại.";
    public static final String TO_MANY_REQUEST = "Bạn đã gửi quá nhiều yêu cầu. Vui lòng thử lại sau.";
    public static final String INCORRECT_PASSWORD = "Mật khẩu sai";

    public static class Validation {
        public static final String NOT_BLANK = "Không thể trống";
        public static final String INVALID_FORMAT_PASSWORD = "Mật khẩu không đủ mạnh (ít nhất 6 ký tự, bao gồm chữ và số)";
        public static final String NOT_NULL= "Trường này là bắt buộc";
        public static final String NOT_EMPTY="Trường này không được để rỗng";
        public static final String INVALID_FORMAT_FIELD="Định dạng không hợp lệ";
        public static final String MUST_IN_PAST = "Ngày phải ở trong quá khứ";
        public static final String MUST_IN_FUTURE = "Ngày phải ở trong tương lai";
        public static final String INVALID_EMPLOYEE_CODE="Mã sinh viên phải có 10 ký tự";
        public static final String POSITIVE="Số nhập vào phải >0";
        public static final String INVALID_SCORE="Điểm phải lớn hơn hoặc bằng 0 và nhỏ hơn hoặc bằng 10";
    }

    public static class Department{
        public static final String ERR_NOT_FOUND_ID ="Không tìm thấy phòng ban nào với id: %s";
        public static final String USERNAME_NOT_FOUND ="Không tìm thấy phòng ban nào với tên: %s";
    }

    public static class Employee{

        public static final String ERR_NOT_FOUND_ID ="Không tìm thấy nhân viên nào với id: %s";

        public static final String USERNAME_NOT_FOUND ="Không tìm thấy nhân viên nào với tên: %s";
    }

    public static class Contract{

        public static final String ERR_NOT_FOUND_ID ="Không tìm thấy hợp đồng nào với id: %s";

    }
}

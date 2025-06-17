package com.foxder.project.REST_APIs.DTOs.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostEmployeeRequest {
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    String email;
    @Size(min = 1, max = 16, message = "Mật khẩu phải từ 1 đến 16 ký tự")
    String password;
    @Size(min = 1, max = 20, message = "Họ tên phải từ 1 đến 20 ký tự")
    String fullName;
    @Size(min = 1, max = 20, message = "Chức vụ phải từ 1 đến 20 ký tự")
    String position;
    @Size(min = 1, max = 20, message = "Trạng thái phải từ 1 đến 20 ký tự")
    String status;
}

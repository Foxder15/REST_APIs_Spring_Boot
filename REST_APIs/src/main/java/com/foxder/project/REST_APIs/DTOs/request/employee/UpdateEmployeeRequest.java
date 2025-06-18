package com.foxder.project.REST_APIs.DTOs.request.employee;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateEmployeeRequest {
    @Size(min = 1, max = 16, message = "Mật khẩu phải từ 1 đến 16 ký tự")
    String password;
    @Size(min = 1, max = 20, message = "Họ tên phải từ 1 đến 20 ký tự")
    String fullName;
    @Size(min = 1, max = 20, message = "Chức vụ phải từ 1 đến 20 ký tự")
    String position;
    @Size(min = 1, max = 20, message = "Trạng thái phải từ 1 đến 20 ký tự")
    String status;
}

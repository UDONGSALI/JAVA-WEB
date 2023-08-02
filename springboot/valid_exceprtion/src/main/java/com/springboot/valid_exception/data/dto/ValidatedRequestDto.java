package com.springboot.valid_exception.data.dto;

import com.springboot.valid_exception.config.annotation.Telephone;
import com.springboot.valid_exception.data.group.ValidationGroup1;
import com.springboot.valid_exception.data.group.ValidationGroup2;
import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ValidatedRequestDto {
    // @Null : Null 값만 허용  @NotNull : Null을 허용하지 않음. "", " "는 허용
    // @NotEmpty : null, ""을 허용하지 않음. " "는 허용 @NotBlank : null, "", " " 모두 허용하지 않음
    //@NotBlank : 위의 두개 합침
    @NotBlank
    private  String name;

    // @Email : 이메일 형식을 검사, ""는 허용
    @Email
    private String email;

    // @Pattern : 정규식을 검사
//    @Pattern(regexp = "01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$")
    @Telephone
    private String phoneNumber;

    @Min(value = 20, groups = ValidationGroup1.class)
    @Max(value = 40, groups = ValidationGroup1.class)
    private int age;

    // @Size(min = $minNumber, max = $maxNumber) : 문자열의 길이를 제한
    @Size(min = 0, max = 40)
    private String description;

    @Positive(groups = ValidationGroup2.class)
    private int count;

    // @AssertTrue : true 체크, null 값은 체크하지 않음    @AssertFalse : false 체크, null 값은 체크하지 않음
    @AssertTrue
    private boolean booleanCheck;

    // @Future : 현재보다 미래의 날짜를 허용   @FutureOrPresent : 현재를 포함한 미래의 날짜를 허용
    // @Past : 현재보다 과거의 날짜를 허용     @PastOrPresent : 현재를 포함한 과거의 날짜를 허용
    // Date birthDay;

    // @Digits : 수치의 범위를 설정합니다.
    // private Integer digits;
}

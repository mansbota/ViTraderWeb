package hr.vitrader.vitraderweb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long personId;
    private String userName;
    private String password;
    private LocalDate dateCreated;
    private double dollarsAmount;
}

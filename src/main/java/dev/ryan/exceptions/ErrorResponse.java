package dev.ryan.exceptions;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private int status;
    private String message;

    @Override
    public String toString() {
        return "ErrorResponse [status=" + status + ", message=" + message + "]";
    }
}

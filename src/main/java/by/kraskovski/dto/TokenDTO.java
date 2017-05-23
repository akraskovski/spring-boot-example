package by.kraskovski.dto;

public class TokenDTO {
    private final String token;
    private final UserDTO user;

    public TokenDTO(final String token, final UserDTO user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public UserDTO getUser() {
        return user;
    }
}

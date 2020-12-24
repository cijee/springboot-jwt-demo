package top.cijee.jwt.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author Cijee
 * @version 1.0
 */
@Slf4j
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (request.getContentType().contains(MediaType.APPLICATION_JSON_VALUE)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Map<String, String> map = objectMapper.readValue(request.getInputStream(), Map.class);
                String username = map.get(super.getUsernameParameter());
                String password = map.get(super.getPasswordParameter());

                if (username == null) {
                    username = "";
                }

                if (password == null) {
                    password = "";
                }
                username = username.trim();
                UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                        username, password);
                setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return super.attemptAuthentication(request, response);
    }
}

/* Created By Sithira Roneth
 * Date :12/6/24
 * Time :10:06
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.config;

import lk.ijse.propmonitoringsystem.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@RequiredArgsConstructor
public class JWTConfigFilter {
//    private final JWTService jwtService;
    private final UserService userService;

    //    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String initToken = request.getHeader("Authorization");
//        String userEmail;
//        String extractedJwtToken;
//
//        //validate token
//        if(StringUtils.isEmpty(initToken)|| !initToken.startsWith("Bearer ")) {
//            filterChain.doFilter(request,response);
//            return;
//        }
//        extractedJwtToken = initToken.substring(7);
//        userEmail = jwtService.extractUserName(extractedJwtToken);
//
//        //user email
//        if (StringUtils.isNotEmpty(userEmail) && SecurityContextHolder.getContext().getAuthentication()==null) {
//            var userDetails = userService.userDetailsService().loadUserByUsername(userEmail);
//            if (jwtService.validateToken(extractedJwtToken,userDetails)) {
//                SecurityContext emptyContext = SecurityContextHolder.createEmptyContext();
//                var authToken = new UsernamePasswordAuthenticationToken(
//                        userDetails,null,userDetails.getAuthorities()
//                );
//                authToken.setDetails((new WebAuthenticationDetailsSource().buildDetails(request)));
//                emptyContext.setAuthentication(authToken);
//                SecurityContextHolder.setContext(emptyContext);
//            }
//            filterChain.doFilter(request,response);
//        }
//    }
}

package service;
 
 
import java.io.IOException;
import java.net.URLDecoder;
  
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
public class CharsetEncodingFilter implements Filter {
     
    @Override  
    public void doFilter(ServletRequest sRequest, ServletResponse sResponse,  
            FilterChain filterChain) throws IOException, ServletException  
    {  
        HttpServletRequest request = (HttpServletRequest) sRequest;  
        HttpServletResponse response = (HttpServletResponse) sResponse;  
        // 设置字符集  
        System.out.println(request.getCharacterEncoding());
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
           
        filterChain.doFilter(request, response);  
    }
 
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
         
    }
 
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
         
    }  
       
}
package pl.coderslab.filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "FilterEncodingFilter")
public class FilterEncodingFilter implements Filter {
  private String encoding;

  public void init(FilterConfig config) throws ServletException {
    encoding = config.getInitParameter("requestEncoding");
    if (encoding == null) {
      encoding = "UTF-8";
    }
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws ServletException, IOException {
    // respect the client-specified character encoding
    if (null == request.getCharacterEncoding()) {
      request.setCharacterEncoding(encoding);
    }
    response.setCharacterEncoding("UTF-8");
    chain.doFilter(request, response);
  }
}

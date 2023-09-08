package com.jamie.web.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/front-end/company/*")
public class CompanyMemberLoginFilter extends HttpFilter {

	private static final long serialVersionUID = 1L;
	
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		String uri = req.getRequestURI();
		Object id = req.getSession().getAttribute("companyMember");
//		HttpSession session = req.getSession(false);  // 如果當前請求沒有有效的Session，直接返回null

		// 從 session 判斷此user是否登入過
		if (id != null) {
			// 如果已經登入且在登入頁面
			if (uri.contains("/companyLogin.html")) {
				resp.sendRedirect(req.getContextPath() + "/front-end/company/companymember/companyIndex.html");

			} else {
				resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate"); // HTTP 1.1
				resp.setHeader("Pragma", "no-cache"); // HTTP 1.0
				resp.setDateHeader("Expires", 0); // Proxies

				chain.doFilter(req, resp);
			}

		} else {
			// 沒有登入，排除註冊和登入相關的資源
			if (uri.contains("/companyRegister.html") || uri.contains("/companyLogin.html") ||
				uri.contains("/company_send_email.html") || uri.contains("/css/") || uri.contains("/js/")) {

				chain.doFilter(req, resp);

			} else {
				resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate"); // HTTP 1.1
				resp.setHeader("Pragma", "no-cache"); // HTTP 1.0
				resp.setDateHeader("Expires", 0); // Proxies

				resp.sendRedirect(req.getContextPath() + "/front-end/company/companymember/companyLogin.html");
			}
		}

	}

}

package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource datasource;

	public DataSource getDatasourceBean() {
		return datasource;
	}

	public void setDatasourceBean(DataSource datasourceBean) {
		this.datasource = datasourceBean;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(datasource)
				.usersByUsernameQuery("select username,password,activated from user where username=?")
				.authoritiesByUsernameQuery(
						"select u.username, r.rolename from user u, roles r where u.iduser = r.iduser and u.username =? ");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
//		http.httpBasic().and().authorizeRequests().antMatchers("/Plat/*").hasAnyAuthority("ROLE_Admin", "ROLE_User");
		http.httpBasic().and().authorizeRequests().antMatchers("/Role/*").hasAuthority("ROLE_Admin");
		http.httpBasic().and().authorizeRequests().antMatchers("/User/*").hasAuthority("ROLE_Admin");

		http.formLogin().loginPage("/login").passwordParameter("password").usernameParameter("username")
				.defaultSuccessUrl("/").failureUrl("/erreur");
		http.logout().logoutSuccessUrl("/");
	}
}

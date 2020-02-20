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
				.usersByUsernameQuery("select username,password,activated from users where username=?")
				.authoritiesByUsernameQuery(
						"select u.username, r.rolename from users u, roles r where u.iduser = r.iduser and u.username =? ");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String roleAdmin = "ROLE_Admin";
		String roleCadre = "ROLE_Cadre";
		String roleEmp = "ROLE_Emp";
		

		http.csrf().disable();
		http.httpBasic().and().authorizeRequests().antMatchers("/Role/*").hasAuthority(roleAdmin);
		http.httpBasic().and().authorizeRequests().antMatchers("/User/*").hasAuthority(roleAdmin);
		http.httpBasic().and().authorizeRequests().antMatchers("/Employe/init").hasAnyAuthority(roleAdmin, roleCadre);
		http.httpBasic().and().authorizeRequests().antMatchers("/Employe/All").hasAnyAuthority(roleAdmin, roleCadre,roleEmp);
		http.httpBasic().and().authorizeRequests().antMatchers("/Employe/find").hasAnyAuthority(roleAdmin, roleCadre,roleEmp);
		http.httpBasic().and().authorizeRequests().antMatchers("/Formulaire/init").hasAnyAuthority(roleAdmin, roleCadre,roleEmp);
		http.httpBasic().and().authorizeRequests().antMatchers("/Formulaire/All").hasAnyAuthority(roleAdmin, roleCadre,roleEmp);
		http.httpBasic().and().authorizeRequests().antMatchers("/Formulaire/All2").hasAnyAuthority(roleAdmin, roleCadre);
		http.httpBasic().and().authorizeRequests().antMatchers("/Formulaire/find").hasAnyAuthority(roleAdmin, roleCadre);
		http.httpBasic().and().authorizeRequests().antMatchers("/Fourniture/All").hasAnyAuthority(roleAdmin, roleCadre);
		http.httpBasic().and().authorizeRequests().antMatchers("/Fourniture/find").hasAnyAuthority(roleAdmin, roleCadre);
		http.httpBasic().and().authorizeRequests().antMatchers("/Document/init").hasAnyAuthority(roleAdmin, roleCadre,roleEmp);
		http.httpBasic().and().authorizeRequests().antMatchers("/Document/All").hasAnyAuthority(roleAdmin, roleCadre,roleEmp);
		http.httpBasic().and().authorizeRequests().antMatchers("/Document/find").hasAnyAuthority(roleAdmin, roleCadre,roleEmp);
		

		http.formLogin().loginPage("/login").passwordParameter("password").usernameParameter("username")
				.defaultSuccessUrl("/").failureUrl("/erreur");
		http.logout().logoutSuccessUrl("/");
	}
}

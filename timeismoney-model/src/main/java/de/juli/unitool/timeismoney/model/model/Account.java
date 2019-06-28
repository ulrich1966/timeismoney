package de.juli.unitool.timeismoney.model.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	  @NamedQuery(name="Account.findAll", query="SELECT model FROM Account model"),
	  @NamedQuery(name="Account.findByName", query="SELECT model FROM Account model WHERE model.name = :name")
	})
public class Account extends Model{
	private String name;
	private String pass;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Account [name=" + name + ", pass=" + pass + "]";
	}
}

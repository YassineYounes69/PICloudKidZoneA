package com.example.kidszonea4arctic3.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class ReportPK implements Serializable{
	    /**
	 * 
	 */
	private static final long serialVersionUID = -4213914526272898865L;
	
		private long idEmployee;
		private long idParent;
	    private long idPost;


	    public ReportPK() {
			super();
		}







		public ReportPK(long idEmployee, long idParent, long idPost) {
			super();
			this.idEmployee = idEmployee;
			this.idParent = idParent;
			this.idPost = idPost;
		}







		public long getIdEmployee() {
			return idEmployee;
		}







		public void setIdEmployee(long idEmployee) {
			this.idEmployee = idEmployee;
		}







		public long getIdParent() {
			return idParent;
		}







		public void setIdParent(long idP) {
			this.idParent = idP;
		}







		public long getIdPost() {
			return idPost;
		}







		public void setIdPost(long idPost) {
			this.idPost = idPost;
		}









	




		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (idEmployee ^ (idEmployee >>> 32));
			result = prime * result + (int) (idParent ^ (idParent >>> 32));
			result = prime * result + (int) (idPost ^ (idPost >>> 32));
			return result;
		}







		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ReportPK other = (ReportPK) obj;
			if (idEmployee != other.idEmployee)
				return false;
			if (idParent != other.idParent)
				return false;
			if (idPost != other.idPost)
				return false;
			return true;
		}







		@Override
		public String toString() {
			return "ReportPK [idEmployee=" + idEmployee + ", idParent=" + idParent + ", idPost=" + idPost + "]";
		}







	}

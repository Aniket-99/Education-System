package com.training.educationsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "study_material_table")
public class StudyMaterial {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "material_id")
	private int materialId;

	@Column(name = "content")
	private String content;

	public StudyMaterial() {
		super();
	}

	public StudyMaterial(int materialId, String content) {
		super();
		this.materialId = materialId;
		this.content = content;
	}

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "StudyMaterial [materialId=" + materialId + ", content=" + content + "]";
	}

}

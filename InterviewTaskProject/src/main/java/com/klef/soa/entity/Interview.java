package com.klef.soa.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Interview_table")
public class Interview {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long interviewId;
private String name;
private String type;
private String status;
private String location;
@CreationTimestamp
private LocalDateTime createdAt;
@UpdateTimestamp
private LocalDateTime updateAt;
public Long getInterviewId() {
	return interviewId;
}
public void setInterviewId(Long interviewId) {
	this.interviewId = interviewId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public LocalDateTime getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
}
public LocalDateTime getUpdateAt() {
	return updateAt;
}
public void setUpdateAt(LocalDateTime updateAt) {
	this.updateAt = updateAt;
}
@Override
public String toString() {
	return "Interview [interviewId=" + interviewId + ", name=" + name + ", type=" + type + ", status=" + status
			+ ", location=" + location + ", createdAt=" + createdAt + ", updateAt=" + updateAt + "]";
}


}

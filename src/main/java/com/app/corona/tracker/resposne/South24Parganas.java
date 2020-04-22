package com.app.corona.tracker.resposne;

public class South24Parganas {
 private float active;
 private float confirmed;
 private float deceased;
 private float recovered;
 private Delta deltaObject;


 // Getter Methods 

 public float getActive() {
  return active;
 }

 public float getConfirmed() {
  return confirmed;
 }

 public float getDeceased() {
  return deceased;
 }

 public float getRecovered() {
  return recovered;
 }

 public Delta getDelta() {
  return deltaObject;
 }

 // Setter Methods 

 public void setActive(float active) {
  this.active = active;
 }

 public void setConfirmed(float confirmed) {
  this.confirmed = confirmed;
 }

 public void setDeceased(float deceased) {
  this.deceased = deceased;
 }

 public void setRecovered(float recovered) {
  this.recovered = recovered;
 }

 public void setDelta(Delta deltaObject) {
  this.deltaObject = deltaObject;
 }
}
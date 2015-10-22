package com.devchronicles.di;

/**
 * @author tanabe
 */
public class User {

  private String fullName;

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    return !(fullName != null ? !fullName.equals(user.fullName) : user.fullName != null);

  }

  @Override
  public int hashCode() {
    return fullName != null ? fullName.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "User{" +
      "fullName='" + fullName + '\'' +
      '}';
  }

}

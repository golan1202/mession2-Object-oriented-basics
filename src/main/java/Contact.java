public class Contact {
    private String name;
    private String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return this.getName() + " " + this.getPhone();
    }

    @Override public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Contact c1 = (Contact)obj;
        return this.getName().equals(c1.getName()) && this.getPhone().equals(c1.getPhone());
    }

    public static void main(String[] args) {
        Contact c1 = new Contact("golan", "241431");
        Contact c2 = new Contact("golan", "241431");
        Contact c3 = new Contact("golan", "dsa431");
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
    }
}



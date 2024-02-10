class User{
    private String userId;
    private String name;
    private String email;

    public User(){
        userId = "00";
        name = "ABC";
        email = "xyz@mail.com";
    }

    public User(String _userId, String _name, String _email){
        userId = _userId;
        name = _name;
        email = _email;
    }
}

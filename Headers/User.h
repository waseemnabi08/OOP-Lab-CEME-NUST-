// User.h
#ifndef USER_H
#define USER_H

#include <iostream>
#include <string>

class User {
public:
    User(const std::string& userId, const std::string& userName, const std::string& email);
    virtual ~User();

    void displayProfile() const;

protected:
    std::string userId;
    std::string userName;
    std::string email;
};

#endif // USER_H

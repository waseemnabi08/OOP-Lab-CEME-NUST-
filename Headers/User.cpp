// User.cpp
#include "User.h"

User::User(const std::string& userId, const std::string& userName, const std::string& email)
    : userId(userId), userName(userName), email(email) {}

User::~User() {}

void User::displayProfile() const {
    std::cout << "User ID: " << userId << "\nName: " << userName << "\nEmail: " << email << std::endl;
}

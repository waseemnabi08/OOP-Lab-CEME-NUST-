#include <iostream>

class Serial{
    static int count;
    int serial;
public:
    Serial(){
        count++;
        serial = count;
    }


    void display() const{
       std :: cout << " I am object # " << serial << std :: endl;
       std :: cout << " Objects created so far : " << count << std :: endl;
    }
};  int Serial :: count = 0;


int main(){
    Serial s1 ,s2, s3;
    s1.display();
    s2.display();
    s3.display();
}

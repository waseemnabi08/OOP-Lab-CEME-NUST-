#include <iostream>

class ToolBooth{
    static unsigned int cars;
    float money;
public:
    ToolBooth(){
        money = 0;
    }


    void payingcar(){
        money += 0.50;
        cars++;
    }

    void nonpayingcar(){
        cars++;
    }

    void display() const {
        std :: cout << "Total number of cars passed : " << cars << std :: endl;
        std :: cout << "Total Tax collected: " << money << std :: endl;
    }
}; unsigned int ToolBooth :: cars = 0;


int main(){
    ToolBooth T1;
    char choice;

    while(true){
        std :: cout << "Press P for Paying car , N for non paying car  and Esc to exit: ";
        std ::cin >> choice;
        if (choice == 'P')
            T1.payingcar();
        else if (choice == 'N')
            T1.nonpayingcar();
        else if (choice == 27)
            break;
        else
            std :: cout << "Invalid choice , enter again : " ;
    }

    T1.display();

}
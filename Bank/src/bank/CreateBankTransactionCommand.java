/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author YYKF
 */
public class CreateBankTransactionCommand  implements BankCommand
{
    Account account;
    double sum;
    
    CreateBankTransactionCommand(double sum, Account account)
    {
        this.sum = sum;
        this.account = account;
    }

    @Override
    public void undo() 
    {
        account.balanceChange(-sum);
    }

    @Override
    public void redo() 
    {
        execute();
    }

    @Override
    public void execute() 
    {
        account.balanceChange(sum);
    }
    
}

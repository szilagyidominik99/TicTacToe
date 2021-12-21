package com.example.tictactoe;

import android.widget.Toast;

public class CheckIsWinnerState {
    String[] winnerImageButtonId;

    public String[] getWinnerImageButtonId() {
        return winnerImageButtonId;
    }

    public boolean isWinnerState(int rowId, int columnId, int[][] buttonsValue, boolean GamerId, int size){
        if(size ==3 ) winnerImageButtonId = new String[3];
        else winnerImageButtonId = new String[4];
        winnerImageButtonId[0] = "btn_" + rowId + "_" + columnId;
        int j = 1;
        int win = 1;
        int helperRow = rowId;
        int helperColumn = columnId;

        //column
        for(int i = rowId-1; i > -1; i--){
            if(GamerId && buttonsValue[i][columnId] == 1){
                win++;
                winnerImageButtonId[j] = "btn_" + i + "_" + columnId;
                j++;
            }
            else if(GamerId && buttonsValue[i][columnId] != 1) break;
            else if(!GamerId && buttonsValue[i][columnId] == 2){
                win++;
                winnerImageButtonId[j] = "btn_" + i + "_" + columnId;
                j++;
            }
            else if(!GamerId && buttonsValue[i][columnId] != 2) break;

            if(size == 3 && win == 3) return true;
            else if(size > 3 && win == 4) return true;
        }

        for(int i = rowId+1; i < size; i++){
            if(GamerId && buttonsValue[i][columnId] == 1){
                win++;
                winnerImageButtonId[j] = "btn_" + i + "_" + columnId;
                j++;
            }
            else if(GamerId && buttonsValue[i][columnId] != 1) break;
            else if(!GamerId && buttonsValue[i][columnId] == 2){
                win++;
                winnerImageButtonId[j] = "btn_" + i + "_" + columnId;
                j++;
            }
            else if(!GamerId && buttonsValue[i][columnId] != 2) break;

            if(size == 3 && win == 3) return true;
            else if(size > 3 && win == 4) return true;
        }

        win = 1;
        j = 1;

        //row
        for(int i = columnId-1; i > -1; i--){
            if(GamerId && buttonsValue[rowId][i] == 1){
                win++;
                winnerImageButtonId[j] = "btn_" + rowId + "_" + i;
                j++;
            }
            else if(GamerId && buttonsValue[rowId][i] != 1) break;
            else if(!GamerId && buttonsValue[rowId][i] == 2){
                win++;
                winnerImageButtonId[j] = "btn_" + rowId + "_" + i;
                j++;
            }
            else if(!GamerId && buttonsValue[rowId][i] != 2) break;

            if(size == 3 && win == 3) return true;
            else if(size > 3 && win == 4) return true;
        }

        for(int i = columnId+1; i < size; i++){
            if(GamerId && buttonsValue[rowId][i] == 1){
                win++;
                winnerImageButtonId[j] = "btn_" + rowId + "_" + i;
                j++;
            }
            else if(GamerId && buttonsValue[rowId][i] != 1) break;
            else if(!GamerId && buttonsValue[rowId][i] == 2){
                win++;
                winnerImageButtonId[j] = "btn_" + rowId + "_" + i;
                j++;
            }
            else if(!GamerId && buttonsValue[rowId][i] != 2) break;

            if(size == 3 && win == 3) return true;
            else if(size > 3 && win == 4) return true;
        }

        win = 1;
        j = 1;

        //sideRow
        while(rowId-1 > -1 && columnId+1  < size){
            if(GamerId && buttonsValue[rowId-1][columnId+1] == 1){
                win++;
                winnerImageButtonId[j] = "btn_" + (rowId-1) + "_" + (columnId+1);
                j++;
            }
            else if(GamerId && buttonsValue[rowId-1][columnId+1] != 1)break;

            else if(!GamerId && buttonsValue[rowId-1][columnId+1] == 2){
                win++;
                winnerImageButtonId[j] = "btn_" + (rowId-1) + "_" + (columnId+1);
                j++;
            }
            else if(!GamerId && buttonsValue[rowId-1][columnId+1] != 2)break;

            rowId--;
            columnId++;

            if(size == 3 && win == 3) return true;
            else if(size > 3 && win == 4) return true;
        }

        rowId = helperRow;
        columnId = helperColumn;

        while(rowId+1 < size && columnId-1 > -1){
            if(GamerId && buttonsValue[rowId+1][columnId-1] == 1){
                win++;
                winnerImageButtonId[j] = "btn_" + (rowId+1) + "_" + (columnId-1);
                j++;
            }
            else if(GamerId && buttonsValue[rowId+1][columnId-1] != 1)break;

            else if(!GamerId && buttonsValue[rowId+1][columnId-1] == 2){
                win++;
                winnerImageButtonId[j] = "btn_" + (rowId+1) + "_" + (columnId-1);
                j++;
            }
            else if(!GamerId && buttonsValue[rowId+1][columnId-1] != 2)break;

            rowId++;
            columnId--;

            if(size == 3 && win == 3) return true;
            else if(size > 3 && win == 4) return true;
        }

        rowId = helperRow;
        columnId = helperColumn;
        win = 1;
        j = 1;

        while(rowId-1 > -1 && columnId-1  > -1){
            if(GamerId && buttonsValue[rowId-1][columnId-1] == 1){
                win++;
                winnerImageButtonId[j] = "btn_" + (rowId-1) + "_" + (columnId-1);
                j++;
            }
            else if(GamerId && buttonsValue[rowId-1][columnId-1] != 1)break;

            else if(!GamerId && buttonsValue[rowId-1][columnId-1] == 2){
                win++;
                winnerImageButtonId[j] = "btn_" + (rowId-1) + "_" + (columnId-1);
                j++;
            }
            else if(!GamerId && buttonsValue[rowId-1][columnId-1] != 2)break;

            rowId--;
            columnId--;

            if(size == 3 && win == 3) return true;
            else if(size > 3 && win == 4) return true;
        }

        rowId = helperRow;
        columnId = helperColumn;

        while(rowId+1 < size && columnId+1 < size){
            if(GamerId && buttonsValue[rowId+1][columnId+1] == 1){
                win++;
                winnerImageButtonId[j] = "btn_" + (rowId+1) + "_" + (columnId+1);
                j++;
            }
            else if(GamerId && buttonsValue[rowId+1][columnId+1] != 1)break;

            else if(!GamerId && buttonsValue[rowId+1][columnId+1] == 2){
                win++;
                winnerImageButtonId[j] = "btn_" + (rowId+1) + "_" + (columnId+1);
                j++;
            }
            else if(!GamerId && buttonsValue[rowId+1][columnId+1] != 2)break;

            rowId++;
            columnId++;

            if(size == 3 && win == 3) return true;
            else if(size > 3 && win == 4) return true;
        }
        return false;
    }
}

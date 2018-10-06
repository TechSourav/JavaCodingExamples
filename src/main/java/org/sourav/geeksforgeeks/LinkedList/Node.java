package org.sourav.geeksforgeeks.LinkedList;

import lombok.*;

public class Node {

    @Getter @Setter
    @RequiredArgsConstructor
    public class SLL{

        /**We are making data as final so that nobody can modify the data. The modification operation is only permisible by
         * deleting the existing node and replace with new node.
         **/
        @NonNull
        private final int data;
        SLL next;
    }

    @Getter @Setter
    @RequiredArgsConstructor
    public class DLL{

        @NonNull
        private final int data;
        DLL left;
        DLL right;
    }

}

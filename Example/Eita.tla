---- MODULE Eita -----
EXTENDS Integers, Types

VARIABLES x, y
vars == <<x, y>>

Init ==
    x = [
        a |-> 5
        ,b |-> "10"
        ,c |-> << 2, 3 >>
        ,d |-> [a |-> 10]
    ]  /\ y = 0

Next ==
    /\ y' = y + 1
    /\ x' = [x EXCEPT !["a"] = IF TypeOf(x["a"]) = "String"
                                THEN 3
                                ELSE "Olha"]

Invariant ==
    y < 3

Alias == 
    [
        typeA |-> TypeOf(x["a"])
        ,typeB |-> TypeOf(x["b"])
        ,typeC |-> TypeOf(x["c"])
        ,typeD |-> TypeOf(x["d"])
    ]

Spec == Init /\ [][Next]_vars

======================

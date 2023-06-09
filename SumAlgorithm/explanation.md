\documentclass{article}

% Pacotes
\usepackage{fancyvrb}
\usepackage{listings}
\usepackage{xcolor}
\usepackage{float}
\usepackage{graphicx}


% Configurações do pacote listings
\lstset{
    basicstyle=\ttfamily,
    keywordstyle=\color{blue},
    stringstyle=\color{red},
    commentstyle=\color{green!70!black},
    numbers=left,
    numberstyle=\tiny\color{gray},
    numbersep=5pt,
    frame=single,
    framesep=5pt,
    xleftmargin=10pt,
    xrightmargin=10pt,
    breaklines=true,
    breakatwhitespace=true,
    mathescape
}

% Configurações de cores
\definecolor{mygray}{rgb}{0.95,0.95,0.95}

% Configurações de float
\floatstyle{plaintop}
\restylefloat{table}

% Título
\title{Projeto e Análise de Algoritmos}
\author{William Santos Silva, Matrícula: 202000013236}
\date{}

\begin{document}
\maketitle

\section*{Questão 1}


\subsection*{(a) Explique sua ideia de solução}

\textbf{Two Sum problem}
Given a sequence $S$ containing $N$ real numbers and a real number $Z$, return two numbers $S_i$ and $S_j$, $i \neq$  j, such that $S_i + S_j = Z$.

To solve this problem we can first sort $S$ and keep track of two pointers, left ($L$) and right ($R$), these pointers will represent the boundaries of of array $S$. 

After sort we can assign our pointers $L = 1$ and $R = N$

We can start now summing $S_L + S_R$,  if $S_L + S_R = Z$ then we have found our answer and we return $S_L + S_R$; otherwise we are left with two cases, $S_L + S_R > Z$ and $S_L + S_R < Z$.

If $S_L + S_R > Z$ that means we must find for smaller values to have a chance to find a match to $Z$, since we want to find a smaller value, we must update $R:=R - 1$

If $S_L + S_R < Z$ that means we must find greater values to sum, then we move the left pointer, $L := L + 1$

\subsection*{(b) Elabore um algoritmo em pseudo-linguagem}

\begin{lstlisting}
Algorithm twoSum(S, n, Z)
Input: an array S of size n and a real number Z
output: all pair of values of S that sum to Z

Let \textbf{result} be an array that at each cell stores two values, x and y

heapsort(S)

L := 1
R := n
while (L < R) do
    if (S[L] + S[R] = Z) then
        result.x := S[L]
        result.y := S[R]
        R := R - 1
        L := L + 1

    if (S[L] + S[R] > Z) then
        R := R - 1
    else    
        L := L + 1

return result;
\end{lstlisting}

\subsection*{(c) Calcule a complexidade de pior caso do algoritmo}

$T(n) = O(nlogn) + O(n) = O(nlogn)$



\end{document}

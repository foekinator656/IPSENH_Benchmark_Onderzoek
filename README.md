het stappen plan voor het gebruiken van de benchmark op een microsoft azure vps.


1. maak de IPSENH_benchmark_onderzoek.jar via https://github.com/foekinator656/IPSENH_Benchmark_Onderzoek . of https://gitlab.inf-hsleiden.nl/s1130767/IPSENH_Benchmark_Onderzoek
2. klik op  “Deploy a virtual machine”
3. Klik dan “create a Linux  virtual machine”
4. zet je regio naar “UK south”
5. zet je Virtual machine name naar “Onderzoek”
6. zet je vps “Size” naar “B1ls”
7. zet “Authentication type” naar password
9. zet je username naar “onderzoek”
10. zet je password naar “Onderzoek2023”
11. druk dan “next" onder aan
12. zet “OS disk type” naar "standard SSD”
13. druk “next” totdat je “de create” knop kan klikken
14. klik dan op de blauwe  “Resource” knop.
15. kopieer de IP-adres van de gekregen VPS.
16. start je terminal(windows) via start -> type cmd -> en dan enter
17. type in “ssh -i "private key path" onderzoek@"azure ip”
- je private key is in je ssh folder in appdata
- de ip heb je in gekopieerd en kan je naast de “@” zetten.
18. doe dan “enter” en dan “yes”
19. type daarna je password van de server in: Onderzoek2023
20. Succes!
21. type nu in de terminal “mkdir benchmark”
22. doe dan “cd benchmark”
23. Installeer dan op je desktop filezilla omdat we de IPSENH_benchmark_onderzoek.jar op de VPS moeten zetten.
24. type in voor host :“sftp://"jouw VPS IP"”
25. type in voor username:”onderzoek”
26. type in voor password: ”Onderzoek2023”
27. type in port: “22”
28. breng nu de IPSENH_benchmark_onderzoek.jar naar de benchmark folder in de server.
29. installer java met “sudo apt-get install openjdk-17-jre”
30. run de jar file met java jar- IPSENH_benchmark_onderzoek.jar
31. type “0” en wacht op het resultaat!

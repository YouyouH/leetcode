#2
SELECT party,
       votes,
       RANK() OVER (ORDER BY votes DESC) as posn
FROM ge
WHERE constituency = 'S14000024 '
  AND yr = 2017
ORDER BY party

#3
SELECT yr,
       party,
       votes,
       RANK() OVER (PARTITION BY yr ORDER BY votes DESC) as posn
FROM ge
WHERE constituency = 'S14000021'
ORDER BY party, yr;

#4
SELECT constituency, party, votes, RANK() OVER (PARTITION BY constituency order by votes DESC ) pos
FROM ge
WHERE constituency BETWEEN 'S14000021' AND 'S14000026'
  AND yr = 2017
ORDER BY pos ASC, constituency ASC;


#5
SELECT constituency, party
FROM (select constituency, party, votes, RANK() over (PARTITION BY constituency order by votes DESC) pos
      from ge
      WHERE constituency BETWEEN 'S14000021' AND 'S14000026'
        and yr = 2017) r
where pos = 1;

#6
select party, count(1) from (
select constituency, party, votes, RANK() over (PARTITION BY constituency order by votes DESC) pos
from ge
WHERE constituency like 'S%'
  and yr = 2017) r where pos = 1 group by party



### https://sqlzoo.net/wiki/More_JOIN_operations

#1
select id, title
from movie
where yr = 1962;

#2
select yr
from movie
where title = 'Citizen Kane';

#3
select id, title, yr
from movie
where title like '%Star Trek%'
order by yr;

#4
select id
from actor
where name = 'Glenn Close';

#5
select id
from movie
where title = 'Casablanca';

###########mutiple join###########
#6
select ac.name
from casting ca
         left join movie mv on ca.movieid = mv.id
         left join actor ac on ac.id = ca.actorid
where mv.id = 11768;

#7
select ac.name
from casting ca
         left join movie mv on ca.movieid = mv.id
         left join actor ac on ac.id = ca.actorid
where mv.title = 'Alien';

#8
select mv.title
from casting ca
         left join movie mv on ca.movieid = mv.id
         left join actor ac on ac.id = ca.actorid
where ac.name = 'Harrison Ford';

#9
select mv.title
from casting ca
         left join movie mv on ca.movieid = mv.id
         left join actor ac on ca.actorid = ac.id
where ac.name = 'Harrison Ford'
  and ca.ord != 1;

#10
select mv.title, ac.name
from casting ca
         left join movie mv on ca.movieid = mv.id
         left join actor ac on ca.actorid = ac.id
where mv.yr = 1962
  and ca.ord = 1;

########### group by and having ###########
#11
select mv.yr, count(mv.title)
from casting ca
         left join movie mv on ca.movieid = mv.id
         left join actor ac on ca.actorid = ac.id
where ac.name = 'Rock Hudson'
group by mv.yr
having count(mv.title) > 2;

#12
select mv.title, ac.name
from casting ca
         left join movie mv on ca.movieid = mv.id
         left join actor ac on ca.actorid = ac.id
where mv.id in (
    select ca.movieid
    from casting ca
             left join actor ac on ca.actorid = ac.id
    where ac.name = 'Julie Andrews')
  and ca.ord = 1;

#13
select ac.name
from actor ac
         left join casting ca on ac.id = ca.actorid
where ca.ord = 1
group by ac.name
having count(ca.movieid) > 14
order by ac.name;

#14
select mv.title, count(ac.id)
from casting ca
         left join movie mv on ca.movieid = mv.id
         left join actor ac on ac.id = ca.actorid
where mv.yr = 1978
group by mv.title
order by count(ac.id) desc, mv.title;

#15
select distinct ac.name
from casting ca
         left join actor ac on ac.id = ca.actorid
where ca.movieid in (
    select ca.movieid
    from casting ca
             left join actor ac on ac.id = ca.actorid
    where ac.name = 'Art Garfunkel'
) and ac.name != 'Art Garfunkel';


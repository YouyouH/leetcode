#8
select ra.company, ra.num
from route ra
         left join route rb on ra.num = rb.num and ra.company = rb.company
         left join stops sa on sa.id = ra.stop
         left join stops sb on sb.id = rb.stop
where sa.name = 'Craiglockhart'
  and sb.name = 'Tollcross'

#9
#Give a distinct list of the stops which may be reached from 'Craiglockhart' by taking one bus,
# including 'Craiglockhart' itself, offered by the LRT company.
# Include the company and bus no. of the relevant services.
select sb.name, ra.company, ra.num
from route ra
         left join route rb on ra.num = rb.num and ra.company = rb.company
         left join stops sa on sa.id = ra.stop
         left join stops sb on sb.id = rb.stop
where sa.name = 'Craiglockhart'
  and ra.company = 'LRT'

#10
#Find the routes involving two buses that can go from Craiglockhart to Lochend.
# Show the bus no. and company for the first bus, the name of the stop for the transfer,
# and the bus no. and company for the second bus.

select r1.num, r1.company, r2.name, r2.num, r2.company
from (select distinct ra.num, ra.company, sb.id end, sb.name
      from route ra
               left join route rb on ra.num = rb.num and ra.company = rb.company
               left join stops sa on ra.stop = sa.id
               left join stops sb on rb.stop = sb.id
      where sa.name = 'Craiglockhart'
        and sb.name != 'Craiglockhart') r1
         inner join (select distinct sa.name, ra.company, ra.num, sa.id start
                     from route ra
                              left join route rb on ra.num = rb.num and ra.company = rb.company
                              left join stops sa on ra.stop = sa.id
                              left join stops sb on rb.stop = sb.id
                     where sb.name = 'Lochend'
                       and sa.name != 'Lochend'
) r2 on r1.end = r2.start
ORDER BY r1.num, r1.name, r2.num
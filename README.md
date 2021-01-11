# Priority
Priority system is for user to give the ratings and ranking to different priority areas such as Career, connection, Relationship, Wealth. 
user can allot different priorities to different areas, along with priority user can rate the satisfaction for all the above areas on a scale of 1 to 5.
Admin can add more areas in the backend and can fetch the whole area list also.

## Request format:
### URL:
http://localhost:8282/user/adduserpreference
## Description:
Accepts the order of priority along with the satisfaction rating for each area for a user and stores it in the database.
### Request Body:
```
{
   "areas":[
      {
         "priorityAreaName":"Career",
         "rank":1,
         "rating":5
      },
      {
         "priorityAreaName":"Connection",
         "rank":4,
         "rating":2
      },
      {
         "priorityAreaName":"Relationship",
         "rank":3,
         "rating":3
      },
      {
         "priorityAreaName":"Wealth",
         "rank":2,
         "rating":4
      }
   ],
   "userId":10
}
```
### URL:
http://localhost:8282/admin/areas
## Description:
Returns a list of all the priority areas from the database.
### Request Body:
```
[
    {
        "priorityName": "Career"
    },
    {
        "priorityName": "Connection"
    },
    {
        "priorityName": "Relationship"
    },
    {
        "priorityName": "Wealth"
    }
]
```
### URL:
http://localhost:8282/admin/addareas
## Description:
Admin can add more areas.
### Request Body:
```
{
   "priorityName":"Friendship"
}
```

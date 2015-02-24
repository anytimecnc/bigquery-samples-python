from __future__ import print_function  # For python 2/3 interoperability
from samples.utils import get_service, query_paging, poll_query


# [START sync_query]
def sync_query(service, project_id, query, timeout=0):
    """ Run a synchronous query"""
    query_data = {
                    'query': query,
                    'timeoutMs': timeout,
                 }

    return service.jobs().query(
            projectId=project_id,
            body=query_data).execute()
# [END sync_query]


# [START main]
def main():
    service = get_service()
    project_id = raw_input("Choose your project ID: ")
    query_string = raw_input("Enter your Bigquery SQL Query: ")

    for page in query_paging(service, poll_query(
            service,
            **sync_query(
                    service,
                    project_id,
                    query_string
                    )['jobReference'])):
        print(page)
# [END main]